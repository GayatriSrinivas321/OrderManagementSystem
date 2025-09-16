public class User {
	private final String name;
	private final String email;
	private final String address;
	
	private USER_STATUS status;
	
	private User(Builder builder) {
	    this.name = builder.name;
	    this.email = builder.email;
	    this.address = builder.address;
	}
	
	public String getName() {
	    return this.name;
	}
	
	public String getEmail() {
	    return this.email;
	}
	
	public String getAddress() {
	    return this.address;
	}
	
	public USER_STATUS getStatus() {
	    return this.status;
	}
	
	public void setStatus(USER_STATUS status) {
	    this.status = status;
	}
	
	    public static class Builder {
	        private String name;
	        private String email;
	        private String address;
	
	        private USER_STATUS status;
	
	        public Builder(String name, String email, String address) {
                this.name = name;
                this.email = email;
                this.address = address;
            }
            
            public Builder(User user) {
                this.name = name;
                this.email = email;
                this.address = address;
                this.status = user.status;
            }
            
            
            public Builder setStatus(USER_STATUS status) {
                this.status = status;
                return this;
            }
            
            
            public User build() {
                return new User(this);
            }
	    }
}
