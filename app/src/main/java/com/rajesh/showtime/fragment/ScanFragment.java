package com.rajesh.showtime.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;
import com.notbytes.barcode_reader.BarcodeReaderFragment;
import com.rajesh.showtime.R;
import com.rajesh.showtime.TicketDetailActivity;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScanFragment extends Fragment implements BarcodeReaderFragment.BarcodeReaderListener {


    private BarcodeReaderFragment barcodeReader;

    public ScanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scan, container, false);
        barcodeReader = (BarcodeReaderFragment) getChildFragmentManager().findFragmentById(R.id.barcode_fragment);
        barcodeReader.setListener(this);
        return view;
    }

    @Override
    public void onScanned(Barcode barcode) {
        Log.e("SCanned", "onScanned: " + barcode.displayValue);
        barcodeReader.playBeep();
        Toast.makeText(getActivity(), "Barcode: " + barcode.displayValue, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), TicketDetailActivity.class);
        getActivity().startActivity(intent);

    }

    @Override
    public void onScannedMultiple(List<Barcode> barcodes) {
        Log.e("Multi list", "onScannedMultiple: " + barcodes.size());

        String codes = "";
        for (Barcode barcode : barcodes) {
            codes += barcode.displayValue + ", ";
        }

        final String finalCodes = codes;
        Toast.makeText(getActivity(), "Barcodes: " + finalCodes, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {

    }

    @Override
    public void onScanError(String errorMessage) {
        Log.e("Scann errror", "onScanError: " + errorMessage);
    }

    @Override
    public void onCameraPermissionDenied() {
        Toast.makeText(getActivity(), "Camera permission denied!", Toast.LENGTH_LONG).show();
    }
}
