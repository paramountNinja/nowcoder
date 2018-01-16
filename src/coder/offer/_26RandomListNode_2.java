package coder.offer;
//@formatter:off
 /**
 *                             _ooOoo_
 *                            o8888888o
 *                            88" . "88
 *                            (| -_- |)
 *                            O\  =  /O
 *                         ____/`---'\____
 *                       .'  \\|     |//  `.
 *                      /  \\|||  :  |||//  \
 *                     /  _||||| -:- |||||-  \
 *                     |   | \\\  -  /// |   |
 *                     | \_|  ''\---/''  |   |
 *                     \  .-\__  `-`  ___/-. /
 *                   ___`. .'  /--.--\  `. . __
 *                ."" '<  `.___\_<|>_/___.'  >'"".
 *               | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *               \  \ `-.   \_ __\ /__ _/   .-` /  /
 *          ======`-.____`-.___\_____/___.-`____.-'======
 *                             `=---='
 *          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 *                     佛祖保佑        永无BUG
 *
 * 描述：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
 //@formatter:on


 public class _26RandomListNode_2 {

     public RandomListNode Clone(RandomListNode pHead) {
         if (pHead == null) return null;
         //第一步将copy的节点插入到相对应的节点的后面A->A'->B->B'
         RandomListNode p = pHead;
         while (p != null) {
             RandomListNode copyNode = new RandomListNode(p.label);
             if (p.next != null)
                 copyNode.next = p.next;
             p.next = copyNode;
             p = copyNode.next;
         }
         //第二步将对应的特殊指针确定
         p = pHead;
         while (p != null) {
             //如果特殊指针指向的不是null！
             if (p.random != null)
                 p.next.random = p.random.next;
             p = p.next.next;
         }
         //第三补将链表拆分成两个！一个原链表一个copy链表
         RandomListNode copyHead = pHead.next;
         p = pHead;
         RandomListNode q = copyHead;
         while (p != null) {
             p.next = p.next.next;
             if (q.next != null)
                 q.next = q.next.next;
             q = q.next;
             p = p.next;
         }
         return copyHead;
     }

     public static void main(String[] args) {
         RandomListNode pNode = new RandomListNode(1);
         RandomListNode pNode1 = new RandomListNode(2);
         RandomListNode pNode2 = new RandomListNode(3);
         pNode.next = pNode1;
         pNode1.next = pNode2;
         _26RandomListNode_2 instance = new _26RandomListNode_2();
         RandomListNode clone = instance.Clone(pNode);
         while (clone != null) {
             System.out.println(clone.label);
             clone = clone.next;
         }
     }
 }
