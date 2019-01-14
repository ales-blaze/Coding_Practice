 static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        newNode.next = null;
        SinglyLinkedListNode tail = head;

        if(tail == null) {
            tail = newNode;
            return tail;
        }        
        while(tail.next != null){                
            tail= tail.next;
        }
        tail.next = newNode;
        return head;
    }