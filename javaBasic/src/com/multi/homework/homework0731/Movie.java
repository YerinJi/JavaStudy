package com.multi.homework.homework0731;

import com.multi.object.arrayclass.Book;

public class Movie {
    private String title;
    private double rating;

    public Movie(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public static void findBestRating(Movie[] movies){
        Movie best = movies[0];
        for(Movie m:movies){
            if(m.rating > best.rating){
                best= m;
            }
        }
        System.out.println("최고 평점 영화: " + best.title + "(평점: " + best.rating + ")");
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                '}';
    }

    public static void main(String[] args) {

        Movie[] movies = {new Movie("인터스텔라", 9.5),
                new Movie("좀비딸",3.5),
                new Movie("F1",4.0)
        };
        Movie.findBestRating(movies);



    }

}
