import static java.lang.Math.*;
class geometry{

    static double volume;
    static double surface;

    public static double cubeVolume(double h){

        volume= pow(h,3) ;
        return volume;
    }

    public static double cubeSurface(double h){

         surface = 6 * pow(h,2);
        return  surface;
    }

    public static double sphereVolume(double r){

        volume = (4.0/3) * Math.PI *pow(r,3);
        return volume;
    }

    public static double sphereSurface(double r){

        surface = 4 * Math.PI * pow(r,2);
        return surface;
    }

    public static double cylinderVolume(double r,double h){

        volume = Math.PI * pow(r,2) * h;
        return volume;
    }

    public static double cylinderSurface(double r,double h){

        surface=2*Math.PI*r*(r+h);
        return surface;
    }

    public static double coneVolume(double r,double h){

        volume=(1.0/3)*Math.PI*pow(r,2)*h;
        return volume;
    }

    public static double coneSurface(double r,double h){

        double l=sqrt((pow(r,2)+pow(h,2)));
        surface=Math.PI*r*(r+l);
        return surface;
    }

}

public class geometrytest{

    public static void main(String args[]){

        System.out.println("Question 2: ");
        double cubevolume=geometry.cubeVolume(5);

        double cubesurface=geometry.cubeSurface(6);

        System.out.println("cubevolume: "+cubevolume+'\n'+"cubesurface: "+cubesurface);

        double spherevolume=geometry.sphereVolume(5);

        double spheresurface=geometry.sphereSurface(6);

        System.out.println("spherevolume: "+spherevolume+'\n'+"spheresurface: "+spheresurface);

        double cylindervolume=geometry.cylinderVolume(3,4);

        double cylindersurface=geometry.cylinderSurface(3,4);

        System.out.println("cylindervolume: "+cylindervolume+'\n'+"cylindersurface: "+cylindersurface);

        double conevolume=geometry.coneVolume(3,4);

        double conesurface=geometry.coneSurface(3,4);

        System.out.println("conevolume: "+conevolume+'\n'+"conesurface: "+conesurface);
    }
}