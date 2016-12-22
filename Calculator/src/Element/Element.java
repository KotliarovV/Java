package Element;
import java.util.ArrayList;

import Number.Number;
import Vectors.VectorND;

public class Element {
	
	public Number number;
	public ArrayList<VectorND> vectors;
	
	
	public Element ()
	{
		number = new Number((float)0,(float)0);
		vectors = new ArrayList<VectorND>();
	}
	
	public Element (Number a)
	{
		number = a;
		vectors = new ArrayList<VectorND>();
	}
	
	public Element (VectorND a)
	{
		number = new Number((float)0,(float)0);
		vectors = new ArrayList<VectorND>();
		vectors.add(a);
	}
	
	public static Element add(Element a1, Element a2)
	{
		Element ans = new Element();
		ans.number = Number.sum(a1.number, a2.number);
		
		if (a1.vectors.size()==0)
			ans.vectors = a2.vectors;
		
		else if (a2.vectors.size()==0)
			ans.vectors = a1.vectors;
		
		else
		{
			ArrayList<Integer> indexes = new ArrayList<Integer>();
			for (VectorND i : a1.vectors)
			{
				boolean findedSameLength = false;
				for (int j =0; j< a2.vectors.size(); j++)
				{
					if (i.Coordinats.length == a2.vectors.get(j).Coordinats.length)
					{
						ans.vectors.add(i.add(a2.vectors.get(j)));
						indexes.add(j);
						findedSameLength = true;
					}
				}
				if (!findedSameLength)
					ans.vectors.add(i);
				
			}
			for (int j =0; j< a2.vectors.size(); j++)
			{
				boolean findedInIndexes = false;
				for (int i = 0; i <indexes.size(); i++ )
				{
					if (indexes.get(i).intValue() == j)
						findedInIndexes = true;
				}
				if (!findedInIndexes)
					ans.vectors.add(a2.vectors.get(j));
			}		
		}
		return ans;
	}
	
	public static Element diff(Element a1, Element a2)
	{
		Element ans = new Element();
		ans.number = Number.diff(a1.number, a2.number);
		
		if (a1.vectors.size()==0)
			{
				for ( VectorND i : a2.vectors)
				{
					ans.vectors.add(i.mult(new Number((float)-1,(float)0)));
				}
			}
		
		else if (a2.vectors.size()==0)
			ans.vectors = a1.vectors;
		
		else
		{
			ArrayList<Integer> indexes = new ArrayList<Integer>();
			for (VectorND i : a1.vectors)
			{
				boolean findedSameLength = false;
				for (int j =0; j< a2.vectors.size(); j++)
				{
					if (i.Coordinats.length == a2.vectors.get(j).Coordinats.length)
					{
						ans.vectors.add(i.diff(a2.vectors.get(j)));
						indexes.add(j);
						findedSameLength = true;
					}
				}
				if (!findedSameLength)
					ans.vectors.add(i);
				
			}
			for (int j =0; j< a2.vectors.size(); j++)
			{
				boolean findedInIndexes = false;
				for (int i = 0; i <indexes.size(); i++ )
				{
					if (indexes.get(i).intValue() == j)
						findedInIndexes = true;
				}
				if (!findedInIndexes)
					ans.vectors.add(a2.vectors.get(j).mult(new Number((float)-1,(float)0)));
			}		
		}
		return ans;
	}


	public static Element mult (Element a1, Element a2)
	{
		Element answ = new Element();
		if (a1.vectors.size() == 0)
		{
			answ.number = Number.mult(a1.number, a2.number);
			for (VectorND vector : a2.vectors)
			{
				answ.vectors.add(vector.mult(a1.number));
			}
		}
		else if (a2.vectors.size() == 0)
		{
			answ.number = Number.mult(a1.number, a2.number);
			for (VectorND vector : a1.vectors)
			{
				answ.vectors.add(vector.mult(a2.number));
			}
		}
		
		else 
		{
			answ.number = Number.sum(Number.mult(a1.number, a2.number), a1.vectors.get(0).scalar(a2.vectors.get(0)));
			VectorND v = a1.vectors.get(0).mult(a2.number).add(a2.vectors.get(0).mult(a1.number));
			answ.vectors.add(v);
		}
		return answ;
	}

	public static Element divide (Element a1, Element a2)
	{
		Element answ = new Element();
		answ.number = Number.divide(a1.number, a2.number);
		for (VectorND i : a1.vectors)
		{
			answ.vectors.add(i.divide(a2.number));
		}
		return answ;
	}
	
	@Override
    public String toString() {
     String el = this.number.toString();
     for (int i = 0; i< this.vectors.size(); i++)
     {
    	 el = el + "+"+ this.vectors.get(i).toString();
     }
     return el;
	}
}
