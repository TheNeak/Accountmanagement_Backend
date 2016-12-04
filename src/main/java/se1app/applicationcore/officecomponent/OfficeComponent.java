package se1app.applicationcore.officecomponent;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Neak on 03.12.2016.
 */
public class OfficeComponent implements OfficeComponentInterface{

    private OfficeRepository officeRepository;

    @Autowired
    public OfficeComponent(OfficeRepository officeRepository)
    {
        this.officeRepository = officeRepository;
    }

    @Override
    public int getNumberOfReservations(Integer officeNr) throws OfficeNotFoundException {
        Office office = officeRepository.findByNr(officeNr);
        if (office == null)
        {
            throw new OfficeNotFoundException(officeNr);
        }
        return office.getNumberOfReservations();
    }


}
