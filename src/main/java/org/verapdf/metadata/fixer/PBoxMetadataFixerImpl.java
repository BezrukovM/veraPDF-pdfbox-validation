package org.verapdf.metadata.fixer;

import org.verapdf.metadata.fixer.impl.pb.FixerConfigImpl;
import org.verapdf.metadata.fixer.utils.FixerConfig;
import org.verapdf.pdfa.MetadataFixerResult;
import org.verapdf.pdfa.results.ValidationResult;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Evgeniy Muravitskiy
 */
public class PBoxMetadataFixerImpl extends MetadataFixerImpl {

	private static MetadataFixerImpl FIXER;

	public PBoxMetadataFixerImpl() {
		// disable default constructor
	}

	@Override
	public MetadataFixerResult fixMetadata(InputStream toFix,
										   OutputStream outputRepaired,
										   ValidationResult result) {
		FixerConfig config = FixerConfigImpl.getFixerConfig(toFix, result);
		return super.fixMetadata(outputRepaired, config);
	}

	public static synchronized MetadataFixerImpl getInstance() {
		return FIXER == null ? FIXER = new PBoxMetadataFixerImpl() : FIXER;
	}

}
