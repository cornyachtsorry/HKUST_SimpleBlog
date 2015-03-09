package blog;
import base.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;

public class Blog {
	private User user;
	private ArrayList<Post> allPosts;
	
	/**
	 * Constructor
	 * @param user
	 */
	public Blog(User user) {
		//TODO
		this.user = user;
		allPosts = new ArrayList<Post>();
	}
	
	/**
	 * 
	 * @param user
	 */
	public void setUser(User user){
		this.user = user;
	}
	
	/**
	 * 
	 * @return
	 */
	public User getUser() {
		return this.user;
	}
	
	
	/**
	 * Create a new post in your blog
	 * @param p
	 */
	public void post(Post p){
		//TODO add Post p to your blog
		boolean succeed = allPosts.add(p);
		//TODO print a message if succeed
		if(succeed == true) {
			System.out.println("A new Post:");
			System.out.println(p);
		}
		else {
			System.out.println("Post failed to be created");
		}
	}
	
	/**
	 * List all posts in the blog
	 */
	public void list() {
		//TODO
		System.out.println("Current posts:");
		for (int i = 0; i < allPosts.size(); i++) {
			System.out.printf("Post[%d]:", i);
			System.out.println(allPosts.get(i));
		}
	}
	
	/**
	 * Delete a post from the blog
	 * @param index
	 */
	public void delete(int index) {
		if (index < 0 || index >= allPosts.size()) {
			System.out.println("Illegal deletion.");
			return;
		}
		allPosts.remove(index);
	}
	
	@Override
	/**
	 * Output this object in string format
	 * @return String
	 */
	public String toString() {
		//TODO
		String s = "Welcome to " + user.getuserName() +"'s blog";
		return s;
	}
	
	@Override
	public int hashCode() {
		//TODO
		return user.hashCode() * allPosts.hashCode();
	}
	
	/**
	 * Search posts created in month and mentioned someone
	 * 
	 * @param month
	 * @param someone
	 */
	public void search(int month, String someone) {
		Calendar cal = Calendar.getInstance();
		//search from all posts
		for (Post p : allPosts) {
			// get the current post's month (note that Calendar.Month starts
			// with 0, not 1)
			cal.setTime(p.getDate());
			int postMonth = cal.get(Calendar.MONTH);
			if ((postMonth+1 == month) && (p.getContent().contains("@" + someone))) {
				System.out.println(p.getDate());
				System.out.println(p.getContent());
			}
		}
	}

	public void setPosts(ArrayList<Post> postList) {
		// TODO Auto-generated method stub
		allPosts = postList;
	}
	
	/**
	@Override
	public boolean equals(Object o) {
		//TODO
		if (this == o) return true;
		if (o == null) return false;
		return true;
	}
	**/
}