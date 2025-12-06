// this should be saved in another faile naamed A.java
// package pack;

// public class A {  // Changed to public class

//     public void msg() {  // Changed to public method
//         System.out.println("Hello");
//     }

// }
package mypack;

import pack.A;

public class B {

    public static void main(String args[]) {
        A obj = new A();  // Now accessible because class A is public
        obj.msg();  // Now accessible because msg() is public
    }
}

//here the class A is declared as public so the object created in B can access if it is not specified then we cant access it is defaault even we import we cant access