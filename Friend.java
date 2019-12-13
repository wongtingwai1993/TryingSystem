import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Friend {
    private Collection<Friend> friends;
    private String email;

    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
    }

    public String getEmail() {
        return email;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    public boolean canBeConnected(Friend friend) {
    	Friend currentTarget = this;
    	
    	System.out.println(currentTarget.getEmail());
    	
    	if(currentTarget.getFriends().contains(friend)) {
    		return true;
    	}
    	
    	Iterator<Friend> iterator = currentTarget.getFriends().iterator();
    	 
    	while(iterator.hasNext()) {
    		Friend nextFriend = iterator.next();
    		nextFriend.friends.remove(currentTarget);
    		
    		if(nextFriend.getEmail().equals(currentTarget.getEmail())) {
    			continue;
    		}
    		return nextFriend.canBeConnected(friend);
    	}
    	return false;

    }

    public static void main(String[] args) {
        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");
        Friend d= new Friend("D");
        
        Friend e= new Friend("E");
        Friend g= new Friend("G");

        a.addFriendship(b);
        b.addFriendship(c);
        c.addFriendship(d);
        
        e.addFriendship(g);

        System.out.println(a.canBeConnected(g));
    }
}