    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        newNode.next = null;
        SinglyLinkedListNode temp = llist;

        if(temp == null){
            temp = newNode;
            return temp;
        }
        newNode.next = temp;
        temp = newNode;
        return temp;
    }
