package com.example.darius.carrental.fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.adapters.RecyclerViewAdapter;
import com.example.darius.carrental.Car;
import com.example.darius.carrental.R;

import java.util.ArrayList;
import java.util.List;

public class OffersFragment extends Fragment {

    List<Car> cars;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_offers, container, false);
        FrameLayout mainGrid = (FrameLayout) view.findViewById(R.id.fragment_container);
        super.onCreate(savedInstanceState);

        cars = new ArrayList<>();
        cars.add(new Car("The Vegitarian","Categorie Car","Description book",R.drawable.thevigitarian));
        cars.add(new Car("The Wild Robot","Categorie Car","Description book",R.drawable.thewildrobot));
        cars.add(new Car("Maria Semples","Categorie Car","Description book",R.drawable.mariasemples));
        cars.add(new Car("The Martian","Categorie Car","Description book",R.drawable.themartian));
        cars.add(new Car("He Died with...","Categorie Car","Description book",R.drawable.hediedwith));
        cars.add(new Car("The Vegitarian","Categorie Car","Description book",R.drawable.thevigitarian));
        cars.add(new Car("The Wild Robot","Categorie Car","Description book",R.drawable.thewildrobot));
        cars.add(new Car("Maria Semples","Categorie Car","Description book",R.drawable.mariasemples));
        cars.add(new Car("The Martian","Categorie Car","Description book",R.drawable.themartian));
        cars.add(new Car("He Died with...","Categorie Car","Description book",R.drawable.hediedwith));
        cars.add(new Car("The Vegitarian","Categorie Car","Description book",R.drawable.thevigitarian));
        cars.add(new Car("The Wild Robot","Categorie Car","Description book",R.drawable.thewildrobot));
        cars.add(new Car("Maria Semples","Categorie Car","Description book",R.drawable.mariasemples));
        cars.add(new Car("The Martian","Categorie Car","Description book",R.drawable.themartian));
        cars.add(new Car("He Died with...","Categorie Car","Description book",R.drawable.hediedwith));

        RecyclerView myrv = (RecyclerView) getActivity().findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(getContext(), cars);
        myrv.setLayoutManager(new GridLayoutManager(getContext(),3));
        myrv.setAdapter(myAdapter);
        return  view;


    }
}
