package naocare.security;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import model.NaocareshopUloga;
import naocare.repositories.NaocareshopUlogaRepository;

public class UlogaConverter implements Converter<String, NaocareshopUloga> {

	NaocareshopUlogaRepository nur;
	
	public UlogaConverter(NaocareshopUlogaRepository nur) {
		this.nur = nur;
	}

	@Override
	public NaocareshopUloga convert(String source) {
		
		int idUloge = -1;
		
		try {
			
			idUloge = Integer.parseInt(source);
		
		} catch(NumberFormatException e) {
			
			throw new ConversionFailedException(TypeDescriptor.valueOf(String.class), TypeDescriptor.valueOf(NaocareshopUloga.class), 
												idUloge, null);
		}
		
		NaocareshopUloga uloga = nur.findById(idUloge).get();
		
		return uloga;
	}	
}
