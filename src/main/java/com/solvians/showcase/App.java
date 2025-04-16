package com.solvians.showcase;

/**
 * Hello world!
 */
public class App {
    public App(String threads, String quotes) {

    }
//    public static void main(String[] arg) {
//        int threads = 3;
//        int quotes = 4;
//        CertificateUpdateGenerator certificateUpdateGenerator = new CertificateUpdateGenerator(threads, quotes);
//        certificateUpdateGenerator.generateQuotes();
//     }

    public static void main(String[] args) {
        int threads;
        int quotes;
        if (args.length >= 2) {
            try{
                 threads = Integer.parseInt(args[0]);
            }catch(Exception e) {
                throw new NumberFormatException("For input string: " + args[0]);
            }

            try{
                quotes = Integer.parseInt(args[1]);
            }catch(Exception e) {
                throw new NumberFormatException("For input string: " + args[1]);
            }

            CertificateUpdateGenerator certificateUpdateGenerator = new CertificateUpdateGenerator(threads, quotes);
            certificateUpdateGenerator.generateQuotes();
        }else {
            throw new RuntimeException("Expect at least number of threads and number of quotes. But got: " + args);
        }
    }
}
