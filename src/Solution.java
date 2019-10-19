import java.util.ArrayList;
import java.util.List;

public class Solution {
        public List<List<String>> printTree(TreeNode root) {
            if(root==null){
                return new ArrayList<>();
            }
            //得到行数也就是树高
            int row=getH(root);
            double high=row;
            //计算列数  2的行数次方是列数
            int col =(int)Math.pow(2.0,high)-1;
            List<List<String>> list=new ArrayList<>();
            //初始化这个数组全部为“ ”
            for(int i=0;i<=row-1;i++){
                ArrayList<String> temp=new ArrayList<>();
                for(int j=0;j<=col-1;j++){
                    temp.add("");
                }
                list.add(temp);
            }
            //修改每一行的值
            getRow(list,root,0,0,col);
            return list;
        }

        //计算每一层
        public void getRow(List<List<String>> list,TreeNode root,int row,int left,int right){
            if(root!=null){
                int mid=(left+right)/2;
                //获取第row行第mid列修改其值
                list.get(row).set(mid,String.valueOf(root.val));
                //递归运算，每个结点的左子树和右子树说都可由根节点运算得来
                //row+1是下一行，root.left为左侧
                getRow(list,root.left,row+1,left,mid);
                //root.right 右侧
                getRow(list,root.right,row+1,mid+1,right);
            }
        }
        //获得树高
        public int getH(TreeNode root){
            if(root==null){
                return 0;
            }else{
                return 1+Math.max(getH(root.left),getH(root.right));
            }
        }
}
