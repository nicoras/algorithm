public class LeetCode66 {

    public int[] plusOne(int[] digits) {
        //如果前面N位是9，可能最终位数需要+1，如9,99,999
        //如果最后一位+1,前面每一位可能需要+1,如799
        //
        int index = digits.length-1;
        int digit = digits[index];
        //1、确认是否N个9
        boolean needRound = true;
        for(int i=0;i<digits.length;i++){
            if(digits[i]!=9){
                needRound = false;
                break;
            }
        }
        //2、如果N个9，则每一位需要整体后移
        if(needRound){
            int[] result = new int[digits.length+1];
            result[0]=1;
            for(int i=1;i<result.length;i++){
                result[i]=0;
            }
            return result;
        }
        //3、如果不是N个9，从后往前处理
        else{
            boolean needPlus = true;
            int i = digits.length-1;
            while(needPlus){
                digits[i] = digits[i]+1;
                if(digits[i]==10){
                    digits[i] = 0;
                    needPlus = true;
                }else{
                    needPlus = false;
                }
                i--;
            }
            return digits;
        }
    }
}
