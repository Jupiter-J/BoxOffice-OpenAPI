package dev.movie.boxoffice.mainApi.repository;

import dev.movie.boxoffice.mainApi.entity.FavMovie;
import dev.movie.boxoffice.mainApi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavMovieRepository extends JpaRepository<FavMovie, Long> {

}
