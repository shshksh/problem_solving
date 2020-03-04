package programmers.Level2;

public class FamilyPhoto {
    char[] arr = new char[] {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    int cnt = 0;
    public int solution(int n, String[] data) {
        perm(0, data);
        return cnt;
    }

    private void perm(int k, String[] data) {
        if(k==arr.length) {
            if(isMeetConditions(arr, data))
                cnt++;
            return;
        }
        for (int i = k; i < arr.length; i++) {
            swap(k, i);
            perm(k+1, data);
            swap(k, i);
        }
    }

    private boolean isMeetConditions(char[] arr, String[] data) {
        String str = new String(arr);
        for (int i = 0; i < data.length; i++) {
            if(!isMeetCondition(str, data[i]))
                return false;
        }
        return true;
    }

    private boolean isMeetCondition(String str, String data) {
        int distance = Math.abs(str.indexOf(data.charAt(0)) - str.indexOf(data.charAt(2))) - 1;
        switch (data.charAt(3)) {
            case'=':
                if(distance + 48 == data.charAt(4))
                    return true;
                break;
            case'>':
                if(distance + 48 > data.charAt(4))
                    return true;
                break;
            case'<':
                if(distance + 48 < data.charAt(4))
                    return true;
                break;
        }
        return false;
    }

    private void swap(int k, int i) {
        char tmp = arr[k];
        arr[k] = arr[i];
        arr[i] = tmp;
    }
}