package com.example.qrscaner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;

import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.barcode.Barcode;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.common.InputImage;


import java.util.List;

public class QRCodeDecoder implements ImageAnalysis.Analyzer {


    BarcodeScannerOptions option;
    BarcodeScanner scanner;
    Context context;

    public QRCodeDecoder(Context context){
        this.context = context;
        option = new BarcodeScannerOptions.Builder().setBarcodeFormats(Barcode.FORMAT_QR_CODE).build();
        scanner = BarcodeScanning.getClient(option);
    }

    @Override
    public void analyze(@NonNull ImageProxy image) {

        @SuppressLint("UnsafeOptInUsageError")
        Image mediaImage = image.getImage();

        if (mediaImage != null){
            int rotationDeg = image.getImageInfo().getRotationDegrees();
            InputImage iImage = InputImage.fromMediaImage(mediaImage, rotationDeg);

            Task<List<Barcode>> result = scanner.process(iImage);
            result.addOnSuccessListener(barcodes -> {
                if (barcodes.size() > 0){
                    Barcode.UrlBookmark urlBookmark = barcodes.get(0).getUrl();
                    String url = null;

                    try{
                        url = urlBookmark.getUrl();
                    }catch (Exception e){
                        url = barcodes.get(0).getDisplayValue();
                    }

                    if (!((MainActivity) context).isProcess && url != null){
                        ((MainActivity) context).isProcess = true;
                        ((MainActivity) context).qeCodeHandler(url);
                    }
                }
                image.close();
            });
            result.addOnFailureListener(e -> image.close());
        }
    }
}
