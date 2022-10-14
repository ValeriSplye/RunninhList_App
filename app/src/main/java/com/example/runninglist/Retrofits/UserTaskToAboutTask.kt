package com.example.runninglist.Retrofits

import com.example.runninglist.AboutTask
import com.example.runninglist.R

public class UserTaskToAboutTask () {

 public fun getItem(UserTask : UserTaskItem) : AboutTask{

    var masstype =  UserTask.description.split(';'); var count : Int =-1
    var diff  = R.drawable.ic_icondelet
    var daily : Boolean
    var Id_EntityImage = R.drawable.ic_iconramk;
    var Id_ArrowImage = R.drawable.ic_iconnext;

    when(masstype[0]){
    "Moday"-> count = 0;
    "Tuesday"-> count = 1;
    "Webnesday"-> count = 2;
    "Thursday"->count =3;
    "Friday"-> count = 4;
     "Saturday"-> count = 5;
     "Sunday"-> count = 6;
    }
     var diffnumber :Int =0;
     if (masstype[1] == "Hard" && UserTask.completed == false) { diff = R.drawable.ic_iconredlvl; diffnumber =3 } // id картинки уровня сложности
     else if (masstype[1] == "Medium" && UserTask.completed ==false) { diff = R.drawable.ic_iconellovlvl; diffnumber =2 }
     else if (masstype[1] == "Eazy" && UserTask.completed    == false) { diff = R.drawable.ic_icongreenlvl; diffnumber=1}

     val ImageArray: IntArray = intArrayOf(0, 0, 0, 0, 0,0,0)
     if (UserTask.week == -1) { daily = true; }
     else { daily = false; }
     if (UserTask.changed == false) {
         if (daily == true) {
             for (i in 0 .. 7) {
                 if (i == count) {
                    ImageArray[i] = diff
                 } else if (i > count) {
                    ImageArray[i] = diff
                 } else {
                     ImageArray[i]= Id_EntityImage
                 }
             }
         } else {
             for (i in 0 ..7) {
                 if (i == count) {
                     ImageArray[i] = diff
                 } else {
                     ImageArray[i] = Id_EntityImage
                 }
             }
         }
     } else {
         if (daily == false) {
             for (i in 0 until count) {
                 ImageArray[i] = Id_ArrowImage
             }
             ImageArray[count] = diff
             for (i in count + 1..7) {
                 ImageArray[i] = Id_EntityImage
             }
         }
     }
     var Id:Int =0;
     var task = AboutTask(Id,UserTask.title,ImageArray[0],ImageArray[1],ImageArray[2],ImageArray[3],ImageArray[4],ImageArray[5],ImageArray[6],UserTask.id,"${count+1}${masstype[1]}")
     return task
 }


}