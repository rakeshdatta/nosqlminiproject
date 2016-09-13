
# COURSE : CMPE 281
# TOPIC  : Mini Project - A NOSQL (Key/Value Pair) Storage Manager is given as an Example i.e. Shore DB SM (Release 2.0) + 
           Java NIO. Students need to Implement a REST based web-server that utilizes this SM DB. 
           This webserver should be replicated across three different EC2 instances - one master and two slaves.
           For the replication purpose, Master and slaves should be able to talk to each other.
           Create a config.properties file where we can configure the webserver as AP or CP mode.
           Simulate network partition and design the webserver such that it concur with AP and CP properties.
           
           
           
                                     _________
                                    | Slave 1 |
                                    /---------
                                   /
                                  /
              http     __________/            _________
             ----->    |  ELB   |------------| Master  |
                       ----------             ---------
                                 \
                                  \
                                   \
                                    \_________
                                    | Slave 2 |
                                     ---------
           

   
    
