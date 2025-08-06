package com.example.w11assignment;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.SearchView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private SearchView searchView;
    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    private List<Player> allPlayers;
    private List<Team> allTeams;
    private List<Match> allMatches;

    private PlayerFragment playerFragment;
    private TeamFragment teamFragment;
    private MatchFragment matchFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchView);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        // Load all data from DataProvider
        allPlayers = DataProvider.createPlayers();
        allTeams = DataProvider.createTeams();
        allMatches = DataProvider.createMatches();

        // Create fragments with initial full data
        playerFragment = PlayerFragment.newInstance(allPlayers);
        teamFragment = TeamFragment.newInstance(allTeams);
        matchFragment = MatchFragment.newInstance(allMatches);

        // Setup ViewPager with FragmentStateAdapter
        viewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                switch (position) {
                    case 0: return playerFragment;
                    case 1: return teamFragment;
                    case 2: return matchFragment;
                    default: return playerFragment;
                }
            }

            @Override
            public int getItemCount() {
                return 3; // Players, Teams, Matches
            }
        });

        // Setup TabLayout with ViewPager2
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0: tab.setText("Players"); break;
                        case 1: tab.setText("Teams"); break;
                        case 2: tab.setText("Matches"); break;
                    }
                }).attach();

        // Setup SearchView listener
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterData(query);
                return true; // handled
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterData(newText);
                return true; // handled
            }
        });
    }

    private void filterData(String query) {
        int currentTab = tabLayout.getSelectedTabPosition();
        if (TextUtils.isEmpty(query)) {
            // Reset to all data if query is empty
            switch (currentTab) {
                case 0: playerFragment.updateData(allPlayers); break;
                case 1: teamFragment.updateData(allTeams); break;
                case 2: matchFragment.updateData(allMatches); break;
            }
            return;
        }

        query = query.toLowerCase();

        switch (currentTab) {
            case 0: // Filter Players by name, team, or position
                List<Player> filteredPlayers = new ArrayList<>();
                for (Player p : allPlayers) {
                    if (p.getName().toLowerCase().contains(query)
                            || p.getTeam().toLowerCase().contains(query)
                            || p.getPosition().toLowerCase().contains(query)) {
                        filteredPlayers.add(p);
                    }
                }
                playerFragment.updateData(filteredPlayers);
                break;

            case 1: // Filter Teams by name, country, or league
                List<Team> filteredTeams = new ArrayList<>();
                for (Team t : allTeams) {
                    if (t.getName().toLowerCase().contains(query)
                            || t.getCountry().toLowerCase().contains(query)
                            || t.getLeague().toLowerCase().contains(query)) {
                        filteredTeams.add(t);
                    }
                }
                teamFragment.updateData(filteredTeams);
                break;

            case 2: // Filter Matches by name, home team, away team, or score
                List<Match> filteredMatches = new ArrayList<>();
                for (Match m : allMatches) {
                    if (m.getName().toLowerCase().contains(query)
                            || m.getHomeTeam().toLowerCase().contains(query)
                            || m.getAwayTeam().toLowerCase().contains(query)
                            || m.getScore().toLowerCase().contains(query)) {
                        filteredMatches.add(m);
                    }
                }
                matchFragment.updateData(filteredMatches);
                break;
        }
    }
}