
interface IFFNN {
	public void activate(Double x1, Double x2);
	public void result();
}

class FFNN implements IFFNN {
	
	public int inpLevelNum;
	public int outLevelNum;
	public int neuronsNum;
	
	public Double inpValues[];
	public Double outValues[];
	public Double inpLevelWeights[];
	public Double outLevelWeights[];
	public Double hidLevelNeurons[];
	
	FFNN(int inpLevelNum, int outLevelNum, int hidLevelNum, int neuronsNum) {
		this.inpLevelNum = inpLevelNum;
		this.outLevelNum = outLevelNum;
		this.neuronsNum = neuronsNum;
		this.inpValues = new Double [inpLevelNum];
		this.outValues = new Double [outLevelNum];
		this.inpLevelWeights = new Double [inpLevelNum*neuronsNum];
		this.outLevelWeights = new Double [outLevelNum*neuronsNum];
		this.hidLevelNeurons = new Double [neuronsNum];
		for (int i = 0; i < inpLevelWeights.length; i++) this.inpLevelWeights[i] = Math.random();
		for (int i = 0; i < outLevelWeights.length; i++) this.outLevelWeights[i] = Math.random();
	}
	
	private Double actFunc(Double x) {
		return 1/(1+Math.exp(-x));
	}
	
	private Double[] layerFunc(Double fLevel[], Double sLevel[], Double weights[]) {
		int offset = 0;
		Double temp = 0.0;
		for(int i = 0; i < sLevel.length; i++) {
			offset = 0;
			temp = 0.0;
			for(int j = 0; j < fLevel.length; j++) {
				temp += fLevel[j]*weights[i+offset];
			    offset += sLevel.length;
			}
			sLevel[i] = actFunc(temp);
		}
		return sLevel;
	}
	
	public void activate(Double x1, Double x2) {
		this.inpValues[0] = x1;
		this.inpValues[1] = x2;
		layerFunc(layerFunc(inpValues,hidLevelNeurons,inpLevelWeights),outValues,outLevelWeights);
	}
	
	public void result() {
		for(Double d: outValues) {
			System.out.println(d);
		}
	}
}	

class ProtoFFNN {
	
	public static FFNN createFFNN(int inNum, int outNum, int hLevelNum, int neuronsNum) {
		return new FFNN(inNum,outNum,hLevelNum,neuronsNum);
	}
	
}

class Learning {
	
	private FFNN lffnn;
	private Double n;
	private Double errors[];
	
	Learning(FFNN lffnn, Double n) {
		this.lffnn = lffnn;
		this.n = n;
		this.errors = new Double[lffnn.neuronsNum+lffnn.outLevelNum];
	}
	
	public void sample(Double x1, Double x2, Double y) {
		lffnn.activate(x1,x2);
		errors[0] = (y-lffnn.outValues[lffnn.outLevelNum-1])*lffnn.outValues[lffnn.outLevelNum-1]*(1-lffnn.outValues[lffnn.outLevelNum-1]);
		for(int i = 1; i < lffnn.neuronsNum+1; i++) {
			errors[i] = errors[0]*lffnn.outLevelWeights[i-1]*lffnn.hidLevelNeurons[i-1]*(1-lffnn.hidLevelNeurons[i-1]);
		}
		for(int i = 0; i < lffnn.outLevelWeights.length; i++) {
			lffnn.outLevelWeights[i] += lffnn.hidLevelNeurons[i]*errors[0]*n;
		}
		lffnn.inpLevelWeights[0] = lffnn.inpValues[0]*errors[1]*n;
		lffnn.inpLevelWeights[1] = lffnn.inpValues[1]*errors[1]*n;
		lffnn.inpLevelWeights[2] = lffnn.inpValues[0]*errors[2]*n;
		lffnn.inpLevelWeights[3] = lffnn.inpValues[1]*errors[2]*n;
		lffnn.inpLevelWeights[4] = lffnn.inpValues[0]*errors[3]*n;
		lffnn.inpLevelWeights[5] = lffnn.inpValues[1]*errors[3]*n;
	}
	
}

public class MyTest {
	
	public static void main(String[] args) {
		FFNN ffnn = ProtoFFNN.createFFNN(2, 1, 1, 3);
		ffnn.activate(1.0, 0.0);
		ffnn.result();
		Learning learn = new Learning(ffnn, 1.0);
		for (int i = 0; i < 10000000; i++) {
			learn.sample(0.0,0.0,0.0);
			learn.sample(0.0,1.0,1.0);
			learn.sample(1.0,0.0,1.0);
			learn.sample(1.0,1.0,0.0);
		}
		ffnn.activate(1.0, 0.0);
		ffnn.result();
	}

}


/*
class FFNN {
	
	public double w1[][] = {{0.132168, 0.2564984}, {0.3655198, 0.198465}, {0.4655198, 0.000465}};
	public double w2[] = {0.0031654, 0.3654987, 0.1654987};
	public double n1,n2,n3,n4;
	
	private double actFunc(double sum) {
		return 1/(1+Math.exp(-sum));
	}
	
	private void layerFunc(int x1, int x2) {
		n1 = actFunc(x1*w1[0][0]+x2*w1[0][1]);
		n2 = actFunc(x1*w1[1][0]+x2*w1[1][1]);
		n3 = actFunc(x1*w1[2][0]+x2*w1[2][1]);
		n4 = actFunc(n1*w2[0]+n2*w2[1]+n3*w2[2]);
	}
	
	public double resultFunc(int x1, int x2) {
		layerFunc(x1,x2);
		return n4;
	}
}

class Learning {
	
	FFNN ffnn;
	private double b1,b2,b3,b4;
	private double n;
	
	Learning(FFNN ffnn, double n) {
		this.ffnn = ffnn;
		this.n = n;
	}
	
	public void sample(int x1, int x2, double y) {
		ffnn.resultFunc(x1, x2);
		b4 = (y-ffnn.n4)*ffnn.n4*(1-ffnn.n4);
		b1 = b4*ffnn.w2[0]*ffnn.n1*(1-ffnn.n1);
		b2 = b4*ffnn.w2[1]*ffnn.n2*(1-ffnn.n2);
		b3 = b4*ffnn.w2[2]*ffnn.n3*(1-ffnn.n3);
		ffnn.w2[0] += (ffnn.n1*b4*n);
		ffnn.w2[1] += (ffnn.n2*b4*n);
		ffnn.w2[2] += (ffnn.n3*b4*n);
		ffnn.w1[0][0] += (x1*b1*n);
		ffnn.w1[0][1] += (x2*b1*n);
		ffnn.w1[1][0] += (x1*b2*n);
		ffnn.w1[1][1] += (x2*b2*n);
		ffnn.w1[2][0] += (x1*b3*n);
		ffnn.w1[2][1] += (x2*b3*n);
	}
}

public class MyTest {
	
	public static void main(String[] args) {
		FFNN ffnn = new FFNN();
		System.out.printf("result=%.2f ", ffnn.resultFunc(30,5));
		System.out.printf("result=%.2f ", ffnn.resultFunc(30,90));
		System.out.printf("result=%.2f ", ffnn.resultFunc(15,5));
		System.out.printf("result=%.2f ", ffnn.resultFunc(15,90));
		System.out.printf("result=%.2f ", ffnn.resultFunc(5,5));
		System.out.printf("result=%.2f \n", ffnn.resultFunc(5,90));
		Learning learn = new Learning(ffnn,1.0);
		for (int i = 0; i < 1000000; i++) {
			learn.sample(30,100,0.95);
			learn.sample(30,40,0.3);
			learn.sample(30,10,0.05);
			learn.sample(20,100,1); 
			learn.sample(20,50,0.6); 
			learn.sample(20,0,0.0); 
			learn.sample(15,90,0.98);
			learn.sample(15,50,0.85);
			learn.sample(15,10,0.1);
			learn.sample(3,80,0.9);
			learn.sample(3,30,0.7);
			learn.sample(3,10,0.4);
			learn.sample(0,80,1);
			learn.sample(0,30,0.9);
			learn.sample(0,10,0.8);
			}
		System.out.printf("result=%.2f ", ffnn.resultFunc(30,5));
		System.out.printf("result=%.2f ", ffnn.resultFunc(30,20));
		System.out.printf("result=%.2f ", ffnn.resultFunc(15,5));
		System.out.printf("result=%.2f ", ffnn.resultFunc(15,90));
		System.out.printf("result=%.2f ", ffnn.resultFunc(5,5));
		System.out.printf("result=%.2f \n", ffnn.resultFunc(5,90));
	}

}*/
