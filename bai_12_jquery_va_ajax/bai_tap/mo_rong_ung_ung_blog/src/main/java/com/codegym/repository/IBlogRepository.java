package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value="SELECT * FROM blog WHERE title LIKE :title AND category_id LIKE :category", nativeQuery = true)
    Page<Blog> search(@Param("category")String category, @Param("title") String title, Pageable pageable);
    @Query(value="SELECT * FROM blog WHERE title LIKE :title AND category_id LIKE :category", nativeQuery = true)
    List<Blog> searchBlog(@Param("category")String category, @Param("title") String title);
}
