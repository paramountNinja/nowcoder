package ctci;
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
 * 描述：对于一个有向图，请实现一个算法，找出两点之间是否存在一条路径。
 * 给定图中的两个结点的指针UndirectedGraphNode* a,UndirectedGraphNode* b
 * (请不要在意数据类型，图是有向图),请返回一个bool，代表两点之间是否存在一条路径(a到b或b到a)。
 */
 //@formatter:on

import java.util.*;

class UndirectedGraphNode {
    int label = 0;
    UndirectedGraphNode left = null;
    UndirectedGraphNode right = null;
    ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

    public UndirectedGraphNode(int label) {
        this.label = label;
    }
}

public class _4_2Path {
    public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
        return check(a, b) || check(b, a);
    }

    private boolean check(UndirectedGraphNode a, UndirectedGraphNode b) {
        if (a == null || b == null)
            return false;
        if (a == b)
            return true;
        Map<UndirectedGraphNode, Boolean> map = new HashMap<>();//该节点是否已访问过
        Deque<UndirectedGraphNode> que = new LinkedList<>();
        que.addLast(a);
        UndirectedGraphNode ptr;
        while (!que.isEmpty()) {
            ptr = que.peekFirst();
            map.put(ptr, true);
            for (int i = 0; i < ptr.neighbors.size(); i++) {
                if (ptr.neighbors.get(i) == b)
                    return true;
                if (map.get(ptr.neighbors.get(i)) == null || !map.get(ptr.neighbors.get(i))) //如果当前邻居节点map中没有值或者没有遍历过
                    que.addLast(ptr.neighbors.get(i));
            }
            que.pollFirst();
        }
        return false;
    }
}

/*
深度优先 用 堆栈
广度优先 用 队列
这题给出了neighbors，所以使用广度优先
图不同于树，我们需要标志哪个节点被访问过，如果都访问过了，还没找到，则false
 */
