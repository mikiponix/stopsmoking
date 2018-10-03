package mikiponix.io.stopsmoking;

public class Card {
    private String key;
    private String goal;
    private String today;
    private String day;
    private int count1;
    private int count2;
    private String diary;
    private int likecount;

    public Card(String key,String goal,String today,String day,int count1,int count2,String diary,int likecount){
        this.key = key;
        this.goal = goal;
        this.today = today;
        this.day = day;
        this.count1 = count1;
        this.count2 = count2;
        this.diary = diary;
        this.likecount = likecount;
    }

    public Card(){

    }

    public String getKey(){
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


    public String getGoal(){
        return goal;
    }

    public void setGoal(String goal){
        this.goal = goal;
    }

    public String getToday(){
        return today;
    }

    public void setToday(String today){
        this.today= today;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day){
        this.day =day;
    }

    public int getCount1(){
        return count1;
    }

    public void setCount1(int count1){
        this.count1 = count1;
    }

    public int getCount2() {
        return count2;
    }
    public void setCount2(int count2){
        this.count2 = count2;
    }

    public String getDiary(){
        return diary;
    }
    public void setDiary(String diary){
        this.diary = diary;
    }

    public int getLikecount(){
        return likecount;
    }

    public void setLikecount(int likecount) {
        this.likecount = likecount;
    }


}




