package db;

import java.io.Serializable;
import java.util.Vector;

public class DataBase implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String[][] v = new String[3][];
	int score = 0;
	DataBase(Vector v1, Vector v2, Vector v3)
	{
		v[0] = new String[v1.size()];
		v[1] = new String[v2.size()];
		v[2] = new String[v3.size()];
		
		for(int i=0; i<v1.size(); i++)
			v[0][i] = v1.get(i).toString();
		for(int i=0; i<v2.size(); i++)
			v[1][i] = v2.get(i).toString();
		for(int i=0; i<v3.size(); i++)
			v[2][i] = v3.get(i).toString();
		
	}
	public void setScore(int x)
	{
		score = x;
	}
	public int getScore()
	{
		return score;
	}
	
}
