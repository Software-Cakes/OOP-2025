package com.example.w11assignment;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;


public class TeamFragment extends Fragment {
    // initialize constructor(s)
    private TeamAdapter adapter;
    private TeamRepository repository;
    public TeamFragment() {}

    // methods
    public static TeamFragment newInstance(List<Team> teams) {
        TeamFragment fragment = new TeamFragment();
        Bundle args = new Bundle();
        args.putSerializable("teams", new ArrayList<>(teams));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.team_fragment, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.teamRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        repository = new TeamRepository();
        List<Team> teams = new ArrayList<>();
        if (getArguments() != null) {
            teams = (List<Team>) getArguments().getSerializable("teams");
            if (teams == null) {
                teams = new ArrayList<>();
            }
        }
        teams.forEach(repository::add);
        adapter = new TeamAdapter(teams);
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void updateData(List<Team> newTeams) {
        repository = new TeamRepository();
        newTeams.forEach(repository::add);
        adapter.updateData(newTeams);
    }
}