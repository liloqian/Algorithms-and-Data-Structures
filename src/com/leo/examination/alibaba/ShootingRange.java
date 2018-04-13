package com.leo.examination.alibaba;

/**
 * @Author: qian
 * @Description
 * @Date: Created in 20:50 2018/3/30
 **/
public class ShootingRange {
    public int deal(int []score) {
        int n=score.length;
        int sum=0;
        for(int j=0;j<n;j++)
        {
            int k=find(score,1,n-1);
            if(k==-1&&(k=find(score,0,n))==-1)break;
            int grade=score[k];//当前靶点得分
            if(k>0){
                int l=k-1;
                while(l>=0&&score[l]==-1)l--;
                if(l>=0){//如果左边存在没打过的靶
                    //如果左边的靶分数不为0
                    if(score[l]>0)grade*=score[l];
                    else continue;//左边的靶分数为结束本次当前循坏
                }
            }
            if(k+1<n){
                int l=k+1;
                while(l<n&&score[l]==-1)l++;
                if(l<n){//如果右边边存在没打过的靶
                    if(score[l]>0)grade*=score[l];
                    else continue;
                }
            }
            sum+=grade;
            score[k]=-1;
        }
        return sum;
    }
    /**
     * 查找最佳打靶点
     * @param score
     * @param j 查找起始位置
     * @param i 查找结束位置
     * @return bestIndex 最佳打靶位置
     */
    private int find(int[] score, int j,int i) {
        int min=Integer.MAX_VALUE;
        int bestIndex=-1;
        for(;j<i;j++){
            //如果当前点score为0或-1，则跳过该点
            if(score[j]<=0)continue;
            if(j>0){
                int k=j-1;//找出左边相邻的靶
                while(k>=0&&score[k]==-1)k--;
                //如果左边相邻的靶为0，则当前靶点无效，打了也是0分，结束本次当前循坏
                if(k>=0&&score[k]==0)continue;
            }
            if(j+1<i){
                int k=j+1;//找出右边相邻的靶
                while(k<i&&score[k]==-1)k++;
                //如果右边相邻的靶为0，则当前靶点无效，打了也是0分，结束本次当前循坏
                if(k<i&&score[k]==0)continue;
            }
            //候选靶点中取较小的靶点
            if(min>score[j]){
                min=score[j];
                bestIndex=j;
            }
        }
        return bestIndex;
    }
}
