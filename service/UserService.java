public class UserService {

    List<User> users;

	public void create(User userDto) {
        System.out.println("Create User : " + userDto.getName());
        
        User user = new User.Builder(userDto.getName(), userDto.getEmail(), userDto.getAddress())
        .setStatus(USER_STATUS.ACTIVE).build();
        
        users.add(user);
        System.out.println("User Saved SuccessFully : "+ userDto.getName());
	}
	
	public void update(int id, User user) throws Exception {
	    System.out.println("Update User Details : "+ id);
	    if(checkUserExists(id)) {
	        users.set(id, user);
	    } else {
	        throw new Exception("Invalid User "+ id);
	    }
	    System.out.println("User Updated SuccessFully : "+ id);
	}
	
	public User get(int id) throws Exception {
	   User user = users.get(id); // SELECT * from Users where id =:id and USER_STATUS = ACTIVE 
	   if(user == null) {
	       throw new Exception("User Doesn't Exists");
	   }
	   return user;
	}
	
	public void delete(int id) throws Exception {
	    if(users.size() > id && USER_STATUS.ACTIVE == users.get(id).getStatus()) {
	        users.get(id).setStatus(USER_STATUS.DEACTIVATE);
	    } else {
	        throw new Exception("User Doesn't Exists or Deactivated");
	    }
	}
	
	public boolean checkUserExists(int id) {
	    return users.size() > id && USER_STATUS.ACTIVE == users.get(id).getStatus();
	}
}