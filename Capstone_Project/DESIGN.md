+-------------------------------------+
| Patient                             |
+-------------------------------------+
| - name : String                     |
| - severity : int                    |
| - arrivalTime : long                |
| - aged : boolean                    |
+-------------------------------------+
| + getName() : String                |
| + getSeverity() : int               |
| + setSeverity(severity: int) : void |
| + arrivalTime() : long              |
| + isAged() : boolean                |
| + setAged(aged: boolean) : void     |
+-------------------------------------+
    ◇
    |
    |
    ◇
+---------------------------------------------------------+
| EmergencyRoomTriage                                     |
+---------------------------------------------------------+
| - triageQueue : PriorityQueue                           |
| - _AGING_THRESHOLD_ : long                              |
+---------------------------------------------------------+
| + addPatient() : void                                   |
| + treatNextPatient(currentTime: long) : Patient         |
| + agingRule(currentTime: long) : void                   |
+---------------------------------------------------------+

Java's PriorityQueue collection is useful for this problem because I can add a patient by their severity level and the queue will sort the queue based on its severity (key) (1 to 5)
The Big-O time complexity I would expect is O(log n) when insertion, searching or traversal a queue
