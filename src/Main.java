import com.iflytek.cloud.speech.*;

public class Main {

    public static void main(String[] args) {
        SpeechUtility.createUtility(SpeechConstant.APPID+"=59a621b6");
        SpeechRecognizer mIat=SpeechRecognizer.createRecognizer();
        mIat.setParameter(SpeechConstant.DOMAIN,"iat");
        mIat.setParameter(SpeechConstant.LANGUAGE,"zh_cn");
        mIat.setParameter(SpeechConstant.ACCENT,"mandarin");
        mIat.setParameter(SpeechConstant.RESULT_TYPE,"plain");

        RecognizerListener recognizerListener=new RecognizerListener() {
            @Override
            public void onVolumeChanged(int i) {
                System.out.println("onVolumeChanged-------->"+i);
            }

            @Override
            public void onBeginOfSpeech() {
                System.out.println("onBeginOfSpeech");
            }

            @Override
            public void onEndOfSpeech() {
                System.out.println("onEndOfSpeech");
            }

            @Override
            public void onResult(RecognizerResult recognizerResult, boolean b) {
                System.out.println(recognizerResult.getResultString());
            }

            @Override
            public void onError(SpeechError speechError) {
                System.out.print(speechError.getErrorDescription(true));
            }

            @Override
            public void onEvent(int i, int i1, int i2, String s) {

            }
        };
        mIat.startListening(recognizerListener);
        while (true){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("repeat");
            if(!mIat.isListening()){
                mIat.startListening(recognizerListener);
            }
        }
    }
}
