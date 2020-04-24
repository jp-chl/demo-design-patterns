package com.jpvr.demodesignpatterns.dp.structural.bridge;

import java.util.ArrayList;
import java.util.List;

public class MoviePrinter extends Printer {

    private Movie movie;

    public MoviePrinter(Movie movie) {
        this.movie = movie;
    } // end constructor

    @Override
    protected List<Detail> getDetails() {

        List<Detail> details = new ArrayList<>();

        details.add(new Detail("Title", movie.getTitle()));
        details.add(new Detail("Year", movie.getYear()));
        details.add(new Detail("Runtime", movie.getRuntime()));

        return details;
    } // end List<Detail> getDetails()

    @Override
    protected String getHeader() {

        return movie.getClasification();
    } // end String getHeader()
} // end class MoviePrinter extends Printer
