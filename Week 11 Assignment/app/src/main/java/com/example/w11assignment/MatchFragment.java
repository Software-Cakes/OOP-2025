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


public class MatchFragment extends Fragment {
    // initialize constructor(s)
    private MatchAdapter adapter;
    private MatchRepository repository;

    public MatchFragment() {}

    // methods
    public static MatchFragment newInstance(List<Match> matches) {
        MatchFragment fragment = new MatchFragment();
        Bundle args = new Bundle();
        args.putSerializable("matches", new ArrayList<>(matches));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.match_fragment, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.matchRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        repository = new MatchRepository();
        List<Match> matches = new ArrayList<>();
        if (getArguments() != null) {
            matches = (List<Match>) getArguments().getSerializable("matches");
            if (matches == null) {
                matches = new ArrayList<>();
            }
        }
        matches.forEach(repository::add);
        adapter = new MatchAdapter(matches);
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void updateData(List<Match> newMatches) {
        repository = new MatchRepository();
        newMatches.forEach(repository::add);
        adapter.updateData(newMatches);
    }
}