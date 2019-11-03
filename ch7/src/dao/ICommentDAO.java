package dao;

import java.util.List;

import domain.Comment;

public interface ICommentDAO {
	public void addComment(Comment comment);

	public Comment getCommentById(String id);

	public void deleteComment(Comment comment);

	public void updateComment(Comment comment);

	public List<Comment> getCommentByTitle(String title);

	public List<Comment> getAllComment();

}
