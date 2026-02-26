package com.blog;

import java.time.LocalDateTime;
import java.util.List;

public class BlogService {

    private UserDAO userDAO = new UserDAO();
    private PostDAO postDAO = new PostDAO();
    private CommentDAO commentDAO = new CommentDAO();

    // Register user
    public void registerUser(User user) {
        userDAO.saveUser(user);
    }

    // Create post
    public void createPost(Post post) {
        post.setCreatedAt(LocalDateTime.now());
        postDAO.savePost(post);
    }

    // Update post
    public void updatePost(Post post) {
        post.setUpdatedAt(LocalDateTime.now());
        postDAO.updatePost(post);
    }

    // Delete post
    public void deletePost(Long id) {
        postDAO.deletePost(id);
    }

    // Add comment
    public void addComment(Comment comment) {
        comment.setCreatedAt(LocalDateTime.now());
        commentDAO.saveComment(comment);
    }

    // Fetch posts by user
    public List<Post> getPostsByUser(Long userId) {
        return userDAO.getPostsByUser(userId);
    }

    // Fetch comments by post
    public List<Comment> getCommentsByPost(Long postId) {
        return postDAO.getCommentsByPost(postId);
    }

    // Fetch comments by user
    public List<Comment> getCommentsByUser(Long userId) {
        return userDAO.getCommentsByUser(userId);
    }
}
