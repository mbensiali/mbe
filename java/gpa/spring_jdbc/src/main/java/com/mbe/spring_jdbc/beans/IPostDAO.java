package com.mbe.spring_jdbc.beans;

import java.util.List;

import com.mbe.spring_jdbc.metier.Post;

public interface IPostDAO {
	List<Post> findAll();
	Post findByID(int id);
	void save(Post p);
}
