package algorithms.basic.tree;
public class CompleteBinaryTree {
    int[] tree; // 완전 이진 트리를 저장할 배열
    int size;   // 현재 노드 수

    // 트리 생성자
    public CompleteBinaryTree(int capacity) {
        tree = new int[capacity]; // 트리의 최대 크기 지정
        size = 0;                // 초기 노드 수는 0
    }

    // 노드 삽입 (완전 이진 트리 구조 유지)
    public void insert(int value) {
        if (size == tree.length) {
            System.out.println("트리가 가득 찼습니다.");
            return;
        }
        tree[size] = value; // 배열의 마지막 위치에 값 추가
        size++;             // 노드 개수 증가
    }

    // 부모 노드 인덱스 가져오기  (부모 공식: (자식 인덱스 - 1) / 2)
    public int getParentIndex(int index) {
        if (index == 0) return -1; // 루트 노드는 부모가 없음
        return (index - 1) / 2;
    }


    // 왼쪽 자식 노드 인덱스 가져오기 (왼쪽 자식 공식: 2 * 부모 인덱스 + 1)
    public int getLeftChildIndex(int index) {
        int leftIndex = 2 * index + 1;
        if (leftIndex >= size) return -1; // 왼쪽 자식 없음
        return leftIndex;
    }

    // 오른쪽 자식 노드 인덱스 가져오기 (2 * 부모 인덱스 + 2)
    public int getRightChildIndex(int index) {
        int rightIndex = 2 * index + 2;
        if (rightIndex >= size) return -1; // 오른쪽 자식 없음
        return rightIndex;
    }

    // 트리 출력
    public void printTree() {
        System.out.println("현재 트리 상태:");
        for (int i = 0; i < size; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CompleteBinaryTree cbt = new CompleteBinaryTree(10); // 최대 10개 노드

        // 노드 삽입
        cbt.insert(10);
        cbt.insert(20);
        cbt.insert(30);
        cbt.insert(40);
        cbt.insert(50);

        // 트리 출력
        cbt.printTree();

        // 부모, 왼쪽 자식, 오른쪽 자식 확인
        int index = 1; // 노드 값 20의 인덱스
        System.out.println("현재 노드: " + cbt.tree[index]);
        System.out.println("부모 노드: " + cbt.tree[cbt.getParentIndex(index)]);
        System.out.println("왼쪽 자식: " + cbt.tree[cbt.getLeftChildIndex(index)]);
        System.out.println("오른쪽 자식: " + cbt.tree[cbt.getRightChildIndex(index)]);
    }
}

