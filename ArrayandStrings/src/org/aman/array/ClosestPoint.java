package org.aman.array;

import java.util.Comparator;
import java.util.*;

class Point{
	int x,y;
	static int count=0;

	Point (){
	}
	Point (int x,int y){
		this.x=x;
		this.y=y;
		count++;
	}
	static int length(){
		return count;
	}
	public String toString(){
		return this.x+","+this.y;
	}
}


class XCoordinateSorter implements Comparator<Point>{
	@Override
	public int compare(Point p1, Point p2) {
		if (p1.x<p2.x)
			return -1;
		else 
			return 1;
	}	
}

class YCoordinateSorter implements Comparator<Point>{
	@Override
	public int compare(Point p1, Point p2) {
		if (p1.y<p2.y)
			return -1;
		else 
			return 1;
	}
}


public class ClosestPoint{	

	public void closestPoint(Point[] points){
		Arrays.sort(points, new XCoordinateSorter() );
		closestUtil(points,points.length);
	}

	public void closestUtil(Point[] points,int n){
		if (points.length<3){
			bruteForce(points);
			return; 
		}
		
		int mid=points.length/2;
		Point pmid=points[mid];
		
		
	}

	public void bruteForce(Point[] points){
		if (points.length<2)
			throw new IllegalArgumentException("Input points is less than 2");
		int minDistance=Integer.MAX_VALUE;
		for (int i=0;i<points.length;i++){
			for (int j=i+1;j<points.length;j++){
				int distance=distance(points[i],points[j]);
				if (distance<minDistance)
					minDistance=distance;
			}
		}
		System.out.println("Minimum distance is:"+minDistance);
	}

	public int  distance(Point p1,Point p2){
		int distance=((p1.x-p2.x)*(p1.x-p2.x)) -((p1.y-p2.y)*(p1.y-p2.y));
		return distance;
	}

	public static void main(String[] args) {
		Point[] points={new Point(6,2),new Point(4,6),new Point(5,4),new Point(-8,2),new Point(0,2)};
		System.out.println(points.length);

		ClosestPoint c1=new ClosestPoint();
		c1.closestPoint(points);
	}
}
