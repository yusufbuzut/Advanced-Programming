package prelab;

public class Image {
	int img_id;
	int num_objects;
	int[] labels;
	int[] xmin;
	int[] xmax;
	int[] ymin;
	int[] ymax;
	
	public Image(int img_id,int label, int xmin, int xmax ,int ymin ,int ymax ) {
		this.img_id = img_id;
		int num_objects = 0;
		this.labels = new int[]{label};
		this.xmax =new int[]{xmax};
		this.xmin =new int[]{xmin};
		this.ymax = new int[]{ymax};
		this.ymin =new int[]{ymin};
	}
	public static void addObject(Image image, int label, int xmin, int xmax ,int ymin ,int ymax) {
		image.setNum_objects(image.getNum_objects());
		image.setLabels(image.getLabels(),label);
		image.setXmax(image.getXmax(), xmax);
		image.setXmin(image.getXmin(), xmin);
		image.setYmax(image.getYmax(), ymax);
		image.setYmin(image.getYmin(), ymin);
	}
	
	public String toString() {
		if (num_objects == 0){
			return img_id + ":" + labels[0] + " " + xmin[0] + " " + xmax[0] + " " + ymin[0]  + " " + ymax[0] + " " + "|" + "\n";
		}
		else {
			return img_id + ":" + labels[0] + " " + xmin[0] + " " + xmax[0] + " " + ymin[0]  + " " + ymax[0] + " " + "|"
		+ " " + labels[1] + " " + xmin[1] + " " + xmax[1] + " " + ymin[1] + " " + ymax	[1] + " " + "|" + "\n";
		}
		
	}
	
	
	
	
	public void setNum_objects(int num_objects) {
		this.num_objects = num_objects +1;
	}
	public void setLabels(int[] labels, int label) {
		int[] newarr = new int[labels.length+1];
		for(int j =0; j< labels.length; j++) {
			newarr[j] = labels[j];
		}
		newarr[labels.length] = label;	
		this.labels = newarr;
				
	}
	public void setXmin(int[] xmin , int i) {
		int[] newarr = new int[xmin.length+1];
		for(int j =0; j< xmin.length; j++) {
			newarr[j] = xmin[j];
		}
		newarr[xmin.length] = i;	
		this.xmin = newarr;
	}
	public void setXmax(int[] xmax , int i) {
		int[] newarr = new int[xmax.length+1];
		for(int j =0; j< xmax.length; j++) {
			newarr[j] = xmax[j];
		}
		newarr[xmax.length] = i;	
		this.xmax = newarr;
	}
	public void setYmin(int[] ymin, int i) {
		int[] newarr = new int[ymin.length+1];
		for(int j =0; j< ymin.length; j++) {
			newarr[j] = ymin[j];
		}
		newarr[ymin.length] = i;	
		this.ymin = newarr;
	}
	public void setYmax(int[] ymax, int i) {
		int[] newarr = new int[ymax.length+1];
		for(int j =0; j< ymax.length; j++) {
			newarr[j] = ymax[j];
		}
		newarr[ymax.length] = i;	
		this.ymax = newarr;
	}
	
	public int getImg_id() {
		return img_id;
	}
	public int getNum_objects() {
		return num_objects;
	}
	public int[] getLabels() {
		return labels;
	}
	public int[] getXmin() {
		return xmin;
	}
	public int[] getXmax() {
		return xmax;
	}
	public int[] getYmin() {
		return ymin;
	}
	public int[] getYmax() {
		return ymax;
	}
	
	
	
	
	
}

