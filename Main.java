import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double rlow;
        double rhigh;
        double rscale;
        double ilow;
        double ihigh;
        double iscale;
        int iteration;
        double zr;
        double zi;
        double cr;
        double ci;
        int part = 1;
        double zrTemp;
        double ziTemp;
        double graph[];
        int x;
        int y;
        graph = new double[7200];
        System.out.println("Lower bound of real axis?");
        rlow= scan.nextDouble();
        System.out.println("Upper bound of real axis?");
        rhigh= scan.nextDouble();
        System.out.println("Lower bound of imaginary axis?");
        ilow= scan.nextDouble();
        System.out.println("Upper bound of imaginary axis?");
        ihigh= scan.nextDouble();
        System.out.println("Real axis resolution?");
        x=scan.nextInt();
        System.out.println("Imaginary axis resolution?");
        y=scan.nextInt();
        System.out.println("How many iterations do you want to do to each point?");
        iteration = scan.nextInt();
        graph = new double[(x*y)];
        rscale= (rhigh-rlow)/(x-1);
        iscale= (ihigh-ilow)/(y-1);
        for (int i=0;i<(x*y);i++){
            part =1;
            zr=0;
            zi=0;
            cr=(i%x)*rscale+rlow;
            ci=((y-1)-(i/x))*iscale+ilow;
            for (int j=0;j<iteration;j++){
                zrTemp=zr;
                ziTemp=zi;
                zr=((zrTemp*zrTemp)-(ziTemp*ziTemp));
                zi=(2*zrTemp*ziTemp);
                zr+=cr;
                zi+=ci;
                if (zr>=2||zr<=-2||zi>=2||zi<=-2){
                   j=iteration+1;
                   part = 0;
                }
            }
            graph[i]=part;
        }
        for (int i=0;i<(x*y);i++){
            if ((i+1)%x==0){
                if (graph[i]==1){
                    System.out.print("X ");
                } else {
                    System.out.print("  ");
                }
                System.out.println();
            } else {
                if (graph[i]==1){
                    System.out.print("X ");
                } else {
                    System.out.print("  ");
                }
            }
        }
    }
}