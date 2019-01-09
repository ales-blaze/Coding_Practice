    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode temp = head;
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        newNode.next = null;

        if(temp == null){ temp = newNode; return head; }

        if(position == 0){
            newNode.next = temp;
            temp = newNode;
            return head;
        }
        
        for(int counter = 1; temp != null ; counter++,temp = temp.next){
            if(counter == position ){
                if(temp.next == null){
                    temp.next = newNode;
                    return head;
                }
                newNode.next = temp.next;
                temp.next = newNode;
                return head;
            }            
        }
        return head;
    }
