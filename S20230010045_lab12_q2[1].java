class FileProcessor extends Thread {
    private String fileType;
    private int processingTime;

    public FileProcessor(String fileType, int processingTime) {
        this.fileType = fileType;
        this.processingTime = processingTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(processingTime);

            synchronized (FileProcessor.class) {
                System.out.println(Thread.currentThread().getName() + " - Processing " + fileType + " file. Time taken: " + processingTime + "ms");
                System.out.println(Thread.currentThread().getName() + " - Finished processing " + fileType + " file.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
 class FileProcessingSystem {
    public static void main(String[] args) {
        FileProcessor imageFile = new FileProcessor("Image", 1000);
        FileProcessor documentFile = new FileProcessor("Document", 2000); 
        FileProcessor videoFile = new FileProcessor("Video", 3000); 

        imageFile.setPriority(Thread.MAX_PRIORITY); 
        documentFile.setPriority(Thread.NORM_PRIORITY); 
        videoFile.setPriority(Thread.MIN_PRIORITY); 

        imageFile.start();
        documentFile.start();
        videoFile.start();
        
        try {
            imageFile.join();
            documentFile.join();
            videoFile.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All file processing completed.");
    }
}
