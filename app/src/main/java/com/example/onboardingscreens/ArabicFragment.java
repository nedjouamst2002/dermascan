package com.example.onboardingscreens;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ArabicFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_arabic, container, false);

        TextView textView = view.findViewById(R.id.arabicContent);
        String content = "<p>DermaScan هو تطبيق موبايل مبتكر مصمم للكشف المبكر عن الميلانوما، وهو نوع من سرطان الجلد. بإستخدام قوة الذكاء الاصطناعي وخوارزميات التعلم العميق، يمكن لتطبيق DermaScan أن يسمح للمستخدمين إما يإلتقاط صورة أو تحميل صورة موجودة لآفة جلدية للتحليل. يهدف هذا التطبيق سهل الاستخدام إلى توفير فحوصات أولية موثوقة للكشف عن الميلانوما، مما يمكّن الأفراد من اتخاذ خطوات استباقية لإدارة صحتهم الجلدية.</p>" +
                "<h3>كيفية إستخدام DermaScan:</h3>" +
                "<h4>إلتقاط أو تحميل صورة:</h4>" +
                "<p><bإلتقاط صورة \"take a photo\"</b>: استخدم الكاميرا المدمجة في التطبيق لإلتقاط صورة واضحة وقريبة للآفة الجلدية التي ترغب في تحليلها.</p>" +
                "<p><b>تحميل صورة \"upload a photo\"</b>: بدلاً من ذلك، يمكنك تحميل صورة موجودة من معرض الصور لديك.</p>" +
                "<p><b>تحليل الصورة \"detect\"</b>: خوارزمية الذكاء الاصطناعي بمعالجة الصورة وتقديم تقييم لاحتمالية أن تكون الآفة ميلانوما.</p>" +
                "<h4>مراجعة النتائج:</h4>" +
                "<p>سيتم عرض النتائج على الشاشة، موضحة إحتمالية أن تكون الآفة ميلانوما. سيظهر التطبيق ما إذا كانت الآفة محتملة أن تكون حميدة أو خبيثة مع مستوى الثقة. يرجى ملاحظة أن هذه أداة فحص أولية وليست تشخيصًا نهائيًا.</p>" +
                "<h4>طلب المشورة المهنية:</h4>" +
                "<p>إذا أشار التطبيق إلى إحتمالية عالية أن تكون الآفة ميلانوما، فمن المهم طلب المشورة الطبية من متخصص بشكل فوري. استشر دائمًا مقدم الرعاية الصحية للحصول على فحص وتشخيص شامل.</p>";

        textView.setText(Html.fromHtml(content));

        return view;
    }
}
