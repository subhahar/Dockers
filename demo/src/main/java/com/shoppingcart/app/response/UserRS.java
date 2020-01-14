package com.shoppingcart.app.response;

import com.shoppingcart.app.model.UserOrder;

public class UserRS {
	private UserOrder user;

	public UserOrder getUser() {
		return user;
	}

	public void setUser(UserOrder user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserRS [user=" + user + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRS other = (UserRS) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
