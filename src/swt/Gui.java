package swt;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Gui {

	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);

		Label labelLocation;
		Label labelContent;
		Label labelExtension;
		Label labelSize;

		Text textLocation;
		Text textContent;
		Text textExtension;
		Text textSize;

		Button buttonBrowse;
		Button buttonClear1;
		Button buttonClear2;
		Button buttonClear3;
		Button buttonClear4;
		Button buttonFind;

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		shell.setLayout(gridLayout);

		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;

		// 1st row
		labelLocation = new Label(shell, SWT.NULL);
		labelLocation.setText("Location: ");

		textLocation = new Text(shell, SWT.SINGLE | SWT.BORDER);
		textLocation.setLayoutData(gridData);

		buttonBrowse = new Button(shell, SWT.PUSH);
		buttonBrowse.setText("Browse");
		// buttonBrowse.setLayoutData(gridData);

		buttonBrowse.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				DirectoryDialog dlg = new DirectoryDialog(shell);

				// Set the initial filter path according
				// to anything they've selected or typed in
				dlg.setFilterPath(textLocation.getText());

				// Change the title bar text
				dlg.setText("SWT's DirectoryDialog");

				// Customizable message displayed in the dialog
				dlg.setMessage("Select a directory");

				// Calling open() will open and run the dialog.
				// It will return the selected directory, or
				// null if user cancels
				String dir = dlg.open();
				if (dir != null) {
					// Set the text box to the new selection
					textLocation.setText(dir);
				}
			}
		});

		// 2nd row.
		labelContent = new Label(shell, SWT.NULL);
		labelContent.setText("Content text: ");

		textContent = new Text(shell, SWT.SINGLE | SWT.BORDER);
		textContent.setLayoutData(gridData);
		buttonClear1 = new Button(shell, SWT.PUSH);
		buttonClear1.setText("Clear");
		// buttonClear.setLayoutData(gridData);

		// 3rd row.
		labelExtension = new Label(shell, SWT.NULL);
		labelExtension.setText("Extension: ");

		textExtension = new Text(shell, SWT.SINGLE | SWT.BORDER);
		textExtension.setLayoutData(gridData);
		buttonClear2 = new Button(shell, SWT.PUSH);
		buttonClear2.setText("Clear");

		// 4th row
		labelSize = new Label(shell, SWT.NULL);
		labelSize.setText("Size: ");

		textSize = new Text(shell, SWT.SINGLE | SWT.BORDER);
		textSize.setLayoutData(gridData);
		buttonClear3 = new Button(shell, SWT.PUSH);
		buttonClear3.setText("Clear");

		// 5th row
		// 4th row
		Label lableFind = new Label(shell, SWT.NULL);
		buttonClear4 = new Button(shell, SWT.PUSH);
		buttonClear4.setText("Clear");
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_END);
		buttonClear4.setLayoutData(gridData);
		buttonFind = new Button(shell, SWT.PUSH);
		buttonFind.setText("Find");

		Group group = new Group(shell, SWT.BORDER);
		group.setText("Group");
		group.setBackground(new Color(Display.getCurrent(), 255, 0, 0));
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gridData.horizontalSpan = 3;
		group.setLayoutData(gridData);

		shell.pack();
		shell.open();
		textLocation.forceFocus();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}
