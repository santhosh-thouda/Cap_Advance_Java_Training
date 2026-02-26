package com.blog;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BlogTest {

    BlogService service = new BlogService();

    //Register User Test
    @Test
    void testRegisterUser() {

        User user = new User();
        user.setName("Santhosh");
        user.setPassword("123");
        user.setEmail("santhosh@gmail.com");

        service.registerUser(user);

        assertNotNull(user.getId());
    }

    //Create Post Test
    @Test
    void testCreatePost() {

        User user = new User();
        user.setName("Author");
        user.setPassword("pass");
        user.setEmail("author@gmail.com");

        service.registerUser(user);

        Post post = new Post();
        post.setTitle("First Post");
        post.setContent("Hibernate Blogging");
        post.setAuthor(user);

        service.createPost(post);

        assertNotNull(post.getId());
    }

    // Add Comment Test
    @Test
    void testAddComment() {

        User user = new User();
        user.setName("User1");
        user.setPassword("pass");
        user.setEmail("u1@gmail.com");

        service.registerUser(user);

        Post post = new Post();
        post.setTitle("Post1");
        post.setContent("Content1");
        post.setAuthor(user);

        service.createPost(post);

        Comment comment = new Comment();
        comment.setContent("Nice post!");
        comment.setPost(post);
        comment.setAuthor(user);

        service.addComment(comment);

        assertNotNull(comment.getId());
    }

    //Fetch Posts By User
    @Test
    void testFetchPostsByUser() {

        User user = new User();
        user.setName("FetchUser");
        user.setPassword("123");
        user.setEmail("fetch@gmail.com");

        service.registerUser(user);

        Post post1 = new Post();
        post1.setTitle("Post A");
        post1.setContent("Content A");
        post1.setAuthor(user);

        Post post2 = new Post();
        post2.setTitle("Post B");
        post2.setContent("Content B");
        post2.setAuthor(user);

        service.createPost(post1);
        service.createPost(post2);

        List<Post> posts = service.getPostsByUser(user.getId());

        assertTrue(posts.size() >= 2);
    }

    // Delete Post Test
    @Test
    void testDeletePost() {

        User user = new User();
        user.setName("DeleteUser");
        user.setPassword("123");
        user.setEmail("delete@gmail.com");

        service.registerUser(user);

        Post post = new Post();
        post.setTitle("ToDelete");
        post.setContent("Delete me");
        post.setAuthor(user);

        service.createPost(post);

        Long id = post.getId();

        service.deletePost(id);

        Post deleted = new PostDAO().findPost(id);

        assertNull(deleted);
    }
}
