package com.example.w11assignment;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PlayerFragment extends Fragment {
    // initialize constructor(s)
    private PlayerAdapter adapter;
    private PlayerRepository repository;
    public PlayerFragment() {}

    // methods
    public static PlayerFragment newInstance(List<Player> players) {
        PlayerFragment fragment = new PlayerFragment();
        Bundle args = new Bundle();
        args.putSerializable("players", new ArrayList<>(players));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.player_fragment, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.playerRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        repository = new PlayerRepository();
        List<Player> players = new ArrayList<>();
        if (getArguments() != null) {
            players = (List<Player>) getArguments().getSerializable("players");
            if (players == null) {
                players = new ArrayList<>();
            }
        }
        players.forEach(repository::add);
        adapter = new PlayerAdapter(players);
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void updateData(List<Player> newPlayers) {
        repository = new PlayerRepository();
        newPlayers.forEach(repository::add);
        adapter.updateData(newPlayers);
    }
}