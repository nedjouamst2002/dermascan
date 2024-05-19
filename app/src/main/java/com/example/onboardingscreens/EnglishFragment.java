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

public class EnglishFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_english, container, false);

        TextView textView = view.findViewById(R.id.englishContent);
        String content = "<p>DermaScan is an innovative mobile application designed for the early detection of melanoma, a type of skin cancer. By leveraging the power of artificial intelligence and deep learning algorithms, DermaScan allows users to either take a photo or upload an existing photo of a skin lesion for analysis. This user-friendly app aims to provide accessible and reliable preliminary screenings for melanoma, empowering individuals to take proactive steps in managing their skin health.</p>" +
                "<h3>How to Use DermaScan:</h3>" +
                "<h4>Take or Upload a Photo:</h4>" +
                "<p><b>Take a Photo:</b> Use the in-app camera to capture a clear, close-up photo of the skin lesion you wish to analyze.</p>" +
                "<p><b>Upload a Photo:</b> Alternatively, you can upload an existing photo from your gallery.</p>" +
                "<p><b>Analyze the Photo:</b> Once the photo is captured or uploaded, tap the 'Detect' button. The AI algorithm will process the image and provide an assessment of whether the lesion is likely to be melanoma.</p>" +
                "<h4>Review Results:</h4>" +
                "<p>The results will be displayed on the screen, indicating the likelihood of the lesion being melanoma. The app will show whether the lesion is likely benign or malignant along with a confidence level. Please note that this is a preliminary screening tool and not a definitive diagnosis.</p>" +
                "<h4>Seek Professional Advice:</h4>" +
                "<p>If the app indicates a high likelihood of melanoma, it is crucial to seek professional medical advice promptly. Always consult with a healthcare provider for a thorough examination and diagnosis.</p>";

        textView.setText(Html.fromHtml(content));

        return view;
    }
}
