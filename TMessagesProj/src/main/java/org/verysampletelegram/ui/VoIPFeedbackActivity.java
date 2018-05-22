package org.verysampletelegram.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.verysampletelegram.messenger.AndroidUtilities;
import org.verysampletelegram.messenger.LocaleController;
import org.verysampletelegram.messenger.MessagesController;
import org.verysampletelegram.messenger.R;
import org.verysampletelegram.tgnet.ConnectionsManager;
import org.verysampletelegram.tgnet.RequestDelegate;
import org.verysampletelegram.tgnet.TLObject;
import org.verysampletelegram.tgnet.TLRPC;
import org.verysampletelegram.ui.ActionBar.AlertDialog;
import org.verysampletelegram.ui.ActionBar.Theme;
import org.verysampletelegram.ui.Components.BetterRatingView;
import org.verysampletelegram.ui.Components.LayoutHelper;
import org.verysampletelegram.ui.Components.voip.VoIPHelper;

public class VoIPFeedbackActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
		super.onCreate(savedInstanceState);

		overridePendingTransition(0, 0);

		setContentView(new View(this));

		VoIPHelper.showRateAlert(this, new Runnable(){
			@Override
			public void run(){
				finish();
			}
		}, getIntent().getLongExtra("call_id", 0), getIntent().getLongExtra("call_access_hash", 0));
	}

	@Override
	public void finish() {
		super.finish();
		overridePendingTransition(0, 0);
	}
}
