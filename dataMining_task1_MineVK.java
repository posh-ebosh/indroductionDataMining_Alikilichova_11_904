package dataMining.task1;

public class MineVK {
    public static void main(String[] args) {
        MineVK mineVK = new MineVK();
        mineVK.checkSubjectsFriends(mineVK.me);
    }

    Group group1 = new Group("1", "music");
    Group group2 = new Group("2", "music");
    Group group3 = new Group("3", "art");
    Group group4 = new Group("4", "art");
    Group group5 = new Group("5", "art");
    Group group6 = new Group("6", "anime");
    Group group7 = new Group("7", "game");
    Group group8 = new Group("8", "game");
    Group group9 = new Group("9", "game");
    Group group10 = new Group("10", "game");
    Group group11 = new Group("11", "anime");
    Group group12 = new Group("12", "game");
    Group group13 = new Group("13", "art");


    User user1 = new User("1", "Ляпустин Никита", new Group[]{group11, group2, group4, group6}, new User[]{});
    User user2 = new User("1", "Латыпов Ришат", new Group[]{group1, group2, group4, group3, group9}, new User[]{});
    User user3 = new User("1", "Ахмадиев Альберт", new Group[]{group3, group4, group5, group6}, new User[]{});//no music
    User user4 = new User("1", "Михеев Сергей", new Group[]{group6, group7, group8, group9}, new User[]{}); // no music
    User user5 = new User("1", "Сосюк Никита", new Group[]{group1, group9, group10, group12}, new User[]{});
    User me = new User("me", "Аликиличова Сабина", new Group[]{group1, group2, group4}, new User[]{user1, user2, user3, user4, user5}); // music

    public String searchFavoriteSubjects(User user){
        String favoriteSubjects =" ";
        int max = 0;

        for (int i = 0; i<user.getGroups().length-1; i++){
            int count = 0;
            for(int j = i+1; j<user.getGroups().length; j++){
                if(user.getGroups()[i].getSubjects()==user.getGroups()[j].getSubjects()){
                    count++;
                }
            }
            if (count> max){
                favoriteSubjects = user.getGroups()[i].getSubjects();
            }
        }

        return favoriteSubjects;
    }

    public void checkSubjectsFriends(User user){
        for (User friend : user.getFriends()){
            for (int i = 0; i<friend.getGroups().length; i++){
                if(friend.getGroups()[i].getSubjects().equals(searchFavoriteSubjects(me))){
                    System.out.println(friend.getName());
                    break;
                }
            }
        }
    }

}


class User {
    private String id = null;
    private String name = null;
    private Group[] groups;
    private User[] friends;


    public User(String id, String name, Group[] groups, User[] friends) {
        this.id = id;
        this.name = name;
        this.groups = groups;
        this.friends = friends;
    }

    public Group[] getGroups() {
        return groups;
    }

    public User[] getFriends() {
        return friends;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

class Group {
    private String idGroup;
    private String subjects;

    public Group(String idGroup, String subjects) {
        this.idGroup = idGroup;
        this.subjects = subjects;
    }

    public String getIdGroup() {
        return idGroup;
    }

    public String getSubjects() {
        return subjects;
    }
}
