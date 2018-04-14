package com.example.demo.service.internal;

import com.example.demo.service.WordLadderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

public class WordLadder implements WordLadderService{

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    private static String dicName = "dictionary.txt";
    private static String dicPath = com.example.demo.service.WordLadderService.class.getClassLoader().getResource("static/"+dicName).getPath();

    public boolean IsAdjacent(String w1,String w2){
        int difference = 0;

        int size1 = w1.length();
        int size2 = w2.length();

        char[] c1 = w1.toCharArray();
        char[] c2 = w2.toCharArray();

        if (size1==size2){
            for (int pos=0;pos<size1;pos++){
                if (c1[pos] != c2[pos])
                    difference++;
                if (difference>1)
                    return false;
            }
            if (difference==1)
                return true;
        }

        if (size1-size2==1) {
            for (int i=0;i<size1;i++) {
                String temp = w1.substring(0,i)+w1.substring(i+1);
                if (temp.equals(w2))
                    return true;
            }
            return false;
        }
        else if(size1-size2==-1) {
            for (int i=0;i<size2;i++) {
                String temp = w2.substring(0,i)+w2.substring(i+1);
                if (temp.equals(w1))
                    return true;
            }
            return false;
        }
        return false;
    }

    public boolean IsExist(Set<String> dic, String word){
        if (dic.contains(word))
            return true;
        return false;
    }

    public boolean IsValid(String w){
        if (w=="")
            return false;
        char[] ca = w.toCharArray();
        for (char ch : ca){
            if (!Character.isLetter(ch))
                return false;
        }
        return true;
    }

    public String PrintStack(Stack<String> s){
        String result="";
        for (String w : s)
            result = w + " " + result;
        return result;
    }

    public String PrintLadder(Stack<String> s, String w1, String w2){
        int size = s.size();
        String result;
        if (size!=0){
            result = "A ladder from " + w2 + " back to " + w1 + ":\n";
            result += PrintStack(s);
        }
        else
            result = "No word ladder from " + w2 + " back to " + w1 + ".";
        return result;
    }

    public Set<String> DicGenerate(String filename)throws IOException {
        Set<String> result = new HashSet<String>();

        DataInputStream in = new DataInputStream(new FileInputStream(filename));
        BufferedReader br  = new BufferedReader(new InputStreamReader(in));
        String temp;

        while((temp = br.readLine())!=null)
            result.add(temp);
        br.close();
        return result;
    }

    public Stack<String> LadderGenerate(String w1, String w2, Set<String> dic){
        Stack<String> result = new Stack<String>();
        if (IsAdjacent(w1, w2)){
            result.push(w1);
            result.push(w2);
        }
        else{
            Queue<Stack<String>> BFS = new LinkedList<Stack<String>>();
            Stack<String> temp = new Stack<String>();
            temp.push(w2);
            BFS.offer(temp);

            while(!BFS.isEmpty()){
                temp = BFS.poll();
                String top = temp.peek();
                int top_size = top.length();
                String neighbour="";
                for (int i=0;i<=top_size;i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        for (int j=0;j<3;j++){
                            if (j==0){
                                if (i<top_size)
                                    neighbour = top.substring(0, i) + ch + top.substring(i + 1, top_size);
                                else
                                    break;
                            }
                            else if (j==1)
                                neighbour = top.substring(0,i)+ ch + top.substring(i,top_size);
                            else{
                                if (i==0)
                                    neighbour = top.substring(1,top_size);
                                else if (i==top_size-1)
                                    neighbour = top.substring(0,top_size-1);
                                else if (i==top_size)
                                    break;
                                else
                                    neighbour = top.substring(0,i-1) + top.substring(i,top_size);
                            }
                            if (dic.contains(neighbour)) {
                                Stack<String> copy = (Stack<String>) temp.clone();
                                copy.push(neighbour);

                                if (IsAdjacent(neighbour, w1)) {
                                    copy.push(w1);
                                    result = copy;
                                    return result;
                                }
                                BFS.offer(copy);
                                dic.remove(neighbour);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public String StringLadderGenerate(String w1, String w2)throws IOException{
        log.debug("Visit dicPath : "+dicPath);
        Set<String> dic = DicGenerate(dicPath);
        log.debug("dic generated.");
        if (!IsValid(w1)){
            return ("The word " + w1 + " is invalid.");
        }
        if (!IsValid(w2)){
            return ("The word " + w2 + " is invalid.");
        }

        w1 = w1.toLowerCase();
        w2 = w2.toLowerCase();

        if (!IsExist(dic,w1)){
            return ("The word" + w1 + " cannot be found in the dictionary.");
        }
        if (!IsExist(dic,w2)) {
            return ("The word" + w2 + " cannot be found in the dictionary.");
        }

        if (w1.equals(w2)){
            return ("The words are the same.");
        }
        Stack<String> result = LadderGenerate(w1, w2, dic);
        String ladder = PrintLadder(result,w1,w2);
        return ladder;
    }

    public String catchIOException(){
        String errmessage = "Dictionary file <"+ dicName +"> fail to be loaded.";
        log.debug(errmessage);
        return errmessage;
    }

    public String CallStringLadderGenerate(String w1, String w2){
        try {
            String ladder = StringLadderGenerate(w1, w2);
            return ladder;
        }
        catch(IOException e){
            log.debug("------Exception------");
            return catchIOException();
        }
    }

}
