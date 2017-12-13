class DataDownloader implements Runnable {
    @Override
    public void run() {
        System.out.printf("Connecting: %s\n",
                           new Date());
        try { 
            TimeUnit.SECONDS.sleep(4); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Download finished: %s\n", 
                           new Date());
    }
}
    @Override
    public void run() {  
		//watcher TERMINATED state
		Blog stateReturn = new Blog();
        User look = new User();
        stateReturn.registerObserver(look);
        System.out.printf("Network connected: %s\n",
                           new Date());
         
        try {
            td.join();
        } catch (InterruptedException e) { 
            e.printStackTrace();
		} System.out.printf("Network not connected: %s\n",new Date()); 
		look.getStatus(td);
    }
}
